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
