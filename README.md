# spring-education

## Mockito 소개

Mock: 진짜 객체와 비슷하게 동작하지만 프로그래머가 직접 그 책체의 행동을 관리하는 객체


### Mock 객체를 만드는방법
1. `Mockito.mock(Mocking을 할 객체의 클래스)`를 사용해 mock객체를 만들수 있으며, static import를 사용하면
`mock(Mocking을 할 객체의 클래스)`로 Mock객체를 만들수 있다.

2. `@ExtendWith(MockitoExtension.class)` Extension을 사용하여
`@Mock`어노테이션으로도 Mock객체를 만들 수 있다.

### Mock 객체 Stubbing
모든 Mock 객체의 행동
- Null을 리턴한다. (Optional 타입은 Optional.empty 리턴)
- Primitive 타입은 기본 Primitive 값을 리턴
- Collection은 비어있는 Collection 리턴
- Void 메소드는 예외를 던지지 않고 아무런 일도 발생하지 않는다.
  - Void 메소드같은 경우는 `doThrow`를 통해 에러를 던질 수있다.

### when

Mock객체의 함수의 반환값 혹은 Parameter를 임의로 정해질수 있음

Parameter를 "아무거나"로 지정하고 싶다면 `any()`를 사용한다.

Builder패턴처럼 then, then, then --- 해서 계속 Mock객체의 결과를 조정할수 있다.

```java
when(userService.registerUser(userDTO)).thenReturn(1L);
given(userService.registerUser(userDTO)).willReturn(1L);
```

```java
verify(userService, times(1)).registerUser(userDTO);
verify(userService, never()).registerUser(userDTO);
then(userService).should(times(1)).registerUser(userDTO);
```

`Given`, `When`, `Then`

어떠한 함수가 어떠한 매개변수로 몇번 호출되어있는지를 판별할수도 있다.

## 기타

Optional로 감싸는 방법은 `Optional.of(감쌀 객체)`

작업