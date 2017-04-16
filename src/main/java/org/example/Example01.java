package org.example;

import java.io.IOException;
import java.util.ResourceBundle;

import org.riversun.slacklet.Slacklet;
import org.riversun.slacklet.SlackletRequest;
import org.riversun.slacklet.SlackletResponse;
import org.riversun.slacklet.SlackletService;

public class Example01 {

	public static void main(String[] args) throws IOException {

		String botToken = ResourceBundle.getBundle("credentials").getString("slack.bot_api_token");

		SlackletService slackService = new SlackletService(botToken);

		slackService.addSlacklet(new Slacklet() {

			@Override
			public void onDirectMessagePosted(SlackletRequest req, SlackletResponse resp) {
				// BOT宛のダイレクトメッセージがポストされた

				String content = req.getContent();

				// メッセージを送信したユーザーのメンションを取得する
				String mention = req.getUserDisp();

				// ダイレクトメッセージを送信したユーザーに対して返信する
				resp.reply(mention + "さん、ダイレクトメッセージありがとう。\n「" + content + "」って言いましたね");
			}

			@Override
			public void onMentionedMessagePosted(SlackletRequest req, SlackletResponse resp) {
				// あるチャンネルでこのBOTへのメンション付きメッセージがポストされた(例　「@smilebot おはよう」）

				String content = req.getContent();

				String mention = req.getUserDisp();
				resp.reply("こんにちは、" + mention + "さん。「" + content + "」って言いましたね。");
			}

		});

		slackService.start();

	}

}
