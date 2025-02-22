
DOCKER_COMPOSE = docker-compose.yml

.PHONY: help
help:
	@echo "Available commands:"
	@echo "  make build       - Build the application"
	@echo "  make run         - Run the application"
	@echo "  make docker-up   - Start services using Docker Compose"
	@echo "  make docker-down - Stop Docker Compose services"
	@echo "  make clean       - Clean the project"

.PHONY: build
build:
	mvn clean package

.PHONY: run
run:
	mvn spring-boot:run

.PHONY: docker-up
docker-up:
	docker-compose -f $(DOCKER_COMPOSE) up -d

.PHONY: docker-down
docker-down:
	docker-compose -f $(DOCKER_COMPOSE) down

.PHONY: clean
clean:
	mvn clean
