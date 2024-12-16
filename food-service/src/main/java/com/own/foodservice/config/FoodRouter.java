//package com.own.foodservice.config;
//
//import com.own.foodservice.Food;
//import com.own.foodservice.FoodDTO;
//import com.own.foodservice.handler.FoodHandler;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import org.springdoc.core.annotations.RouterOperation;
//import org.springdoc.core.annotations.RouterOperations;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
//import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
//
//@Configuration
//public class FoodRouter {
//
//    @Bean
//    @RouterOperations({
//            @RouterOperation(path = "/foods"
//                    , produces = {
//                    MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST,
//                    beanClass = FoodHandler.class, beanMethod = "createFood",
//                    operation = @Operation(operationId = "createFood", responses = {
//                            @ApiResponse(responseCode = "201", description = "Created successfully",
//                                    content = @Content(schema = @Schema(implementation = Food.class))),
//                            @ApiResponse(responseCode = "400", description = "Error"),
//                            @ApiResponse(responseCode = "500", description = "Unpredicted error")}
//                            , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = FoodDTO.class))))
//            ),
//    })
//    public RouterFunction<ServerResponse> route(FoodHandler foodHandler) {
//
//        return RouterFunctions
//                .route()
//                .path("/foods", builder -> builder
//                        .GET("/roll", accept(MediaType.APPLICATION_JSON), foodHandler::foodRoll)
//                        .POST(foodHandler::createFood)
//                        .PUT("/{id}", foodHandler::updateFood)
//                        .DELETE("/{id}", foodHandler::removeFood)
//                        .GET("/{id}", accept(MediaType.APPLICATION_JSON), foodHandler::foodById)
//                        .GET(accept(MediaType.APPLICATION_JSON), foodHandler::food)
//                )
//                .build();
//    }
//}
