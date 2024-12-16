//package com.own.foodservice.handler;
//
//import com.own.foodservice.Difficulty;
//import com.own.foodservice.Food;
//import com.own.foodservice.FoodService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//
//@Component
//@RequiredArgsConstructor
//public class FoodHandler {
//
//    private final FoodService foodService;
//
//    public Mono<ServerResponse> food(ServerRequest request) {
//        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters
//                        .fromPublisher(foodService.getFood(
//                                Integer.parseInt(request.queryParam("page").orElse("0")),
//                                Integer.parseInt(request.queryParam("size").orElse("10"))
//                        ), Food.class));
//    }
//
//    public Mono<ServerResponse> foodById(ServerRequest request) {
//        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters
//                        .fromPublisher(foodService.getFood(Long.valueOf(request.pathVariable("id"))), Food.class)
//                );
//    }
//
//    public Mono<ServerResponse> foodRoll(ServerRequest request) {
//        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters
//                        .fromPublisher(foodService.getFood(Difficulty.valueOf(request.queryParam("difficulty").orElse(String.valueOf(Difficulty.EASY)))), Food.class));
//    }
//
//    public Mono<ServerResponse> createFood(ServerRequest serverRequest) {
//        return serverRequest.bodyToMono(Food.class) // Считываем тело запроса как объект Food
//                .flatMap(food -> foodService.createFood(food)) // Передаем объект в сервис
//                .flatMap(savedFood -> ServerResponse
//                        .status(HttpStatus.CREATED) // Устанавливаем статус "201 Created"
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .bodyValue(savedFood)) // Возвращаем созданный объект
//                .onErrorResume(error -> ServerResponse
//                        .badRequest() // Если ошибка, возвращаем статус 400
//                        .bodyValue("Error creating food: " + error.getMessage()));
//    }
//
//    public Mono<ServerResponse> updateFood(ServerRequest serverRequest) {
//        return serverRequest.bodyToMono(Food.class) // Считываем тело запроса
//                .flatMap(food -> foodService.updateFood(Long.valueOf(serverRequest.pathVariable("id")), food)) // Передаем ID и объект в сервис
//                .flatMap(updatedFood -> ServerResponse
//                        .ok()
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .bodyValue(updatedFood)) // Возвращаем обновленный объект
//                .onErrorResume(error -> ServerResponse
//                        .badRequest()
//                        .bodyValue("Error updating food: " + error.getMessage()));
//    }
//
//    public Mono<ServerResponse> removeFood(ServerRequest serverRequest) {
//        return null;
//    }
//}
