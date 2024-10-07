GRADLE = ./gradlew

.PHONY: build
build: 
	$(GRADLE) build

.PHONY: run
run: 
	$(GRADLE) run

.PHONY: clean
clean:
	$(GRADLE) clean