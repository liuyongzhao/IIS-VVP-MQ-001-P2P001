import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TestProducer {

    public static final String QUEUE_NAME = "MessageType_Test";
        public static void main(String[] argv)throws java.io.IOException, TimeoutException {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Success!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" 消息发送完毕!发送的消息是： '" + message + "'");

            channel.close();
            connection.close();
        }
}
