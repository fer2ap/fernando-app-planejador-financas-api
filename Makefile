build:
	sudo docker build -t fer2ap/fernando-app-planejador-financas-api:1.0 . && sudo docker build -t fer2ap/fernando-app-planejador-financas-api:latest .

dev: 
	docker run --rm -p 8080:8080 fer2ap/fernando-app-planejador-financas-api

up:
	make build && docker compose up

db:
	docker compose up db