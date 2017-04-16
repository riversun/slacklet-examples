package org.example;

import java.io.IOException;
import java.util.ResourceBundle;

import org.riversun.slacklet.SlackletService;

public class Example02 {

	public static void main(String[] args) throws IOException {

		String botToken = ResourceBundle.getBundle("credentials").getString("slack.bot_api_token");

		SlackletService slackService = new SlackletService(botToken);
		slackService.start();

		// ユーザーに対して、（返信ではなく）ダイレクトメッセージを送る
		String userName = "riversun";
		slackService.sendDirectMessageTo(userName, "こんちは～");

		// slackとの接続を終了
		slackService.stop();

	}

}
