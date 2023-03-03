package commands;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class BotCommands extends ListenerAdapter {

	@Override
	public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

		if (event.getName().equals("launch")) {
			
			event.reply("Missiles launching in 3... 2... 1...").queue();
		}else if(event.getName().equals("food")) {
			
			OptionMapping option = event.getOption("foodname");
			
			if(option == null) {
				event.reply("Provide a food name idiot.").queue();
				
				return;
			}
			
			String favoriteFood = option.getAsString();
			
			event.reply("Your favorite food is " + favoriteFood + ".").queue();
		}

		 //Temperature conversion function
		 else if(event.getName().equals("convert")){

			OptionMapping option1 = event.getOption("temperature");
			OptionMapping option2 = event.getOption("units");


			if(option1 == null || option2 == null){
				event.reply("No inputs were given").queue();
			}

			if(option2.getAsString().equals("F")){
				
				double output = (option1.getAsDouble() - 32)*(5/9);
				event.reply(option1.getAsDouble() + " F is " + output + " C in celsius.").queue();
			}else if(option2.getAsString().equals("C")){
				double output = ((9*option1.getAsDouble())/5)+32;
				
				event.reply(option1.getAsDouble() + " C is " + output + " F in fahrenheit.").queue();
			}


		}
	}

	
	
}
