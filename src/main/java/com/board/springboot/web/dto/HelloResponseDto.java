package com.board.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;

@Getter // 선언된 모든 필드의 get 메소드를 생성
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성. final이 없는 필드는 생성자에 포함되지 않음 -> 오류 발생 => 해결
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
