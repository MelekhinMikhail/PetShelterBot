package edu.group5.petshelterbot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {
    private final Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);
    @Autowired
    private final TelegramBot tgBot;

    public TelegramBotUpdatesListener(TelegramBot tgBot) {
        this.tgBot = tgBot;
    }

    @PostConstruct
    public void init() {
        tgBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.stream().filter(update -> update.message() != null).forEach(update -> {
            logger.info("Processing update: {}", update);
            Message msg = update.message();
            Long chatId = msg.chat().id();
            String text = msg.text();

            if ("/start".equals(text)) {
                sendMessage(chatId, "Приветствую, бот-помощник готов к работе.");
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    // Метод для простого ответа.
    private void sendMessage(Long chatId, String message) {
        SendMessage sendMessage = new SendMessage(chatId, message);
        SendResponse sendResponse = tgBot.execute(sendMessage);
        if (!sendResponse.isOk()) logger.error("ERROR SENDING MESSAGE: {}", sendResponse.description());
    }


}
