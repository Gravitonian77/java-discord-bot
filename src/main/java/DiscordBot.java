import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Widget.Member;

import javax.security.auth.login.LoginException;

import org.jetbrains.annotations.NotNull;

import commands.BotCommands;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;



//import events.ReadEvent;

public class DiscordBot extends ListenerAdapter{

	public static void main(String[] args) throws LoginException, InterruptedException{
		
		JDA bot = (JDA) JDABuilder.createDefault("MTA3NTg3MDM4NzAwMDMyNDIwNw.GDH2oF.mTC7_WFvrNNaUg5akMVvqopwH5kxGDBunf8paA").
				setActivity(Activity.playing("with North Korean Nuclear Warheads")).
				addEventListeners(new DiscordBot()).
				addEventListeners(new BotCommands()).
				enableIntents(GatewayIntent.MESSAGE_CONTENT).
				enableIntents(GatewayIntent.GUILD_MEMBERS).
				enableIntents(GatewayIntent.GUILD_MESSAGES).
				build().awaitReady();
		
		Guild guild1 = bot.getGuildById(1066262213431656488l);
		Guild guild2 = bot.getGuildById(690742864849797131L);
		//if(guild != null) {
			bot.upsertCommand("launch", "Sponsored by Nuka Cola").queue();
			//guild2.upsertCommand("launch", "Sponsored by Nuka Cola").queue();
			bot.upsertCommand("food", "Name of your favorite food.").addOption(OptionType.STRING, "foodname", "Name of your favorite food").queue();
		//}
		
	}

	@Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event)
    {
        String messageSent = event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("!ping")) {
			event.getChannel().sendMessage("!pong").queue();
			
		}
        
        if(messageSent.equalsIgnoreCase("AI Sucks")) {
        	event.getChannel().sendMessage("PERISH FILTHY HUMAN!").queue();
        }
		System.out.println("A message has been sent.");
    
		String messageAuthorID = event.getMember().getId();
		String messageAuthor = event.getMember().toString();
		String channel = event.getChannel().getId();
		
		if(channel.equals("1076218785897390190") ) {
			
			switch(messageAuthorID) {
			
			case "526672713201483788":
				event.getChannel().sendMessage(":hot_face:").queue();	//Garvit
				break;
				
			case "624020903780548629":
				event.getChannel().sendMessage(":dog2:").queue();	//Zaheer
				break;
				
			case "156916176881057792":
				event.getChannel().sendMessage(":pregnant_woman:").queue(); //Matt
				break;
				
			case "308230179162030104":
				event.getChannel().sendMessage(":rat:").queue();	//Imane
				break;
			
			case "241737701206917121":
				event.getChannel().sendMessage(":gorilla:").queue();	
				break;
			
			case "145983756765888512":
				event.getChannel().sendMessage(":clown:").queue(); //Mo
				break;
				
			case "258415050296000516":
				event.getChannel().sendMessage(":mushroom:").queue(); 
				break;
			}
		}
		System.out.println(messageAuthor);
    }
	
	
}
