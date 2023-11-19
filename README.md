# AutoChannelCreator

Der AutoChannelCreator ist ein Java-Programm, das automatisch Teamspeak 3 Sprachkanäle erstellt. Die Konfiguration erfolgt über die Datei `config.json`.

## Konfigurationsdatei: config.json

Die Konfigurationsdatei enthält verschiedene Parameter, die für den Betrieb des AutoChannelCreators erforderlich sind. Hier sind die möglichen Einträge in der `config.json`:

```json
{
  "serverip": "your_server_ip",
  "query_port": "your_query_port",
  "nickname": "your_bot_nickname",
  "query_login": "your_query_username",
  "query_password": "your_query_password",
  "channel_id_creator": "your_channel_id_creator",
  "channelid_placer": "your_channel_id_placer",
  "channelid_entry": "your_entry_channel_id",
  "channel_admin": "your_channel_admin_id"
}
```

## Erklärung der Einträge:

- **serverip**: Die IP-Adresse des Teamspeak 3 Servers.
- **query_port**: Der Query-Port des Teamspeak 3 Servers.
- **nickname**: Der gewünschte Nickname des Bots.
- **query_login**: Der Benutzername für die Query-Verbindung.
- **query_password**: Das Passwort für die Query-Verbindung.
- **channel_id_creator**: Die Channel-ID, in der der AutoChannelCreator neue Kanäle erstellt.
- **channelid_placer**: Die Channel-ID, in der der AutoChannelCreator neue Kanäle platziert.
- **channelid_entry**: Die Channel-ID, in welche die Query zurück Joinen soll.
- **channel_admin**: Die Channel-ID der Admin Gruppe.

## Endprodukt:
![NVIDIA_Share_iDWae0thZM](https://github.com/qeinz/AutoChannelCreator/assets/66924611/fec995ae-a023-49b2-b747-39f0b84ec035)


