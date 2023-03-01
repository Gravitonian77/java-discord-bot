package events;

//import net.dv8tion.jda.api.events.guild.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadEvent extends ListenerAdapter{

	public void onGuildMessageReceived(MessageReceivedEvent event) {
		String messageSent = event.getMessage().getContentRaw();
		if(messageSent.equalsIgnoreCase("!ping")) {
			event.getChannel().sendMessage("!pong").queue();
		}
	}
	
}
