package commands;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class BotCommands extends ListenerAdapter {

	@Override
	public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

		//super.onSlashCommandInteraction(event);
		
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
	}

	
	
}
