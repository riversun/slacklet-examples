package org.example;

import java.io.IOException;
import java.util.ResourceBundle;

import org.riversun.slacklet.Slacklet;
import org.riversun.slacklet.SlackletRequest;
import org.riversun.slacklet.SlackletResponse;
import org.riversun.slacklet.SlackletService;
import org.riversun.slacklet.SlackletSession;

public class Example04 {

	public static void main(String[] args) throws IOException {

		String botToken = ResourceBundle.getBundle("credentials").getString("slack.bot_api_token");

		SlackletService slackService = new SlackletService(botToken);

		slackService.addSlacklet(new Slacklet() {

			@Override
			public void onDirectMessagePosted(SlackletRequest req, SlackletResponse resp) {

				String content = req.getContent();

				// セッションを取得する（セッションはユーザー毎に固有）
				SlackletSession session = req.getSession();

				// 発言回数カウント用のintegerをセッションから取得する。未だ何も入れていないときは、デフォルト値１とする
				Integer num = (Integer) session.getAttribute("num", 1);

				resp.reply(req.getUserDisp() + "さんは" + num + "回目に「" + content + "」って言いました。");

				// 回更をインクリメントして、セッションを更新する
				num++;
				session.setAttribute("num", num);

			}

		});

		slackService.start();

	}

}
