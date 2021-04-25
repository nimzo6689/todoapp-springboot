Spring Boot で作成した Todo アプリです。

# 実行手順

データベースを作成する。

```bash
sqlite3 todo.sqlite3 < ./setup/db/schema.sql
```

Web アプリケーションを実行

「Run」または、以下のコマンドを実行する。

```bash
sh ./mvnw spring-boot:run
```
