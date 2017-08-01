package org.example;

import java.io.IOException;
import java.util.ResourceBundle;

import org.riversun.slacklet.SlackletService;
import org.riversun.xternal.simpleslackapi.SlackAttachment;

public class Example05 {

	public static void main(String[] args) throws IOException {

		String botToken = ResourceBundle.getBundle("credentials").getString("slack.bot_api_token");

		SlackletService slackService = new SlackletService(botToken);
		slackService.start();

		final String imageUrl = "https://riversun.github.io/img/riversun_144.png";

		final SlackAttachment attchImage = new SlackAttachment();
		attchImage.setTitle("");
		attchImage.setText("");
		attchImage.setFallback("");
		attchImage.setColor("#ffffff");
		attchImage.setImageUrl(imageUrl);

		// チャンネルに対して、画像つきメッセージを送る
		String channelName = "random";
		slackService.sendMessageTo(channelName, "randomチャンネルの皆様、こんにちは！",attchImage);

		slackService.stop();

	}

}
