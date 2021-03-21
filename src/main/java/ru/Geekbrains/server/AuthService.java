package ru.Geekbrains.server;

public interface AuthService {
    String getNicknameByLoginAndPassword(String login, String password);
}

