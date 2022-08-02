using System;
using System.Text;
using Newtonsoft.Json;
using RabbitMQ.Client;

namespace RabbitMQ_Learn.Producer;

public class Program
{
    public Program()
    {
        
    }

    static void Main(string[] args)
    {
        var factory = new ConnectionFactory() 
        {
             Uri = new Uri("amqp://guest:guest@localhost:5672")
        };

        using var connection = factory.CreateConnection();
        using var channelModel = connection.CreateModel();

        channelModel.QueueDeclare(
            "demo-queue", 
            durable: true, 
            exclusive: false, 
            autoDelete: false,
            arguments: null );
        
        var message = new {Name= "Damilola", Message = "Hello!!"};
        var body = Encoding.UTF8.GetBytes(JsonConvert.SerializeObject(message));
        channelModel .BasicPublish("", "demo-queue", null, body);

    }
}