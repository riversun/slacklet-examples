package org.example;

import java.io.IOException;
import java.util.ResourceBundle;

import org.riversun.slacklet.SlackletService;

public class Example03 {

	public static void main(String[] args) throws IOException {

		String botToken = ResourceBundle.getBundle("credentials").getString("slack.bot_api_token");

		SlackletService slackService = new SlackletService(botToken);
		slackService.start();

		// チャンネルに対して、（返信ではなく）ダイレクトメッセージを送る
		String channelName = "random";
		slackService.sendMessageTo(channelName, "randomチャンネルの皆様、こんにちは！");

		slackService.stop();

	}

}
