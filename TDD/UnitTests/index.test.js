const sut = require("./index"); //system under test, 대상 시스템
const faker = require("faker");

test('sut transforms "hello  world"', () => {
  const actual = sut("hello  world");
  expect(actual).toBe("hello world");
});

test('transforms "hello    world', () => {
  const actual = sut("hello    world");
  expect(actual).toBe("hello world");
});

test('transforms "hello   world', () => {
  //공백이 3개일 경우 test 실패
  const actual = sut("hello   world");
  expect(actual).toBe("hello world");
});

//source에 따른 test를 진행하는 코드 작성
//이 경우 실제 결과값과 실패했음은 알 수 있지만 3가지 소스 중 어떤 데이터가 실패했는지는 알 수 없음
//또, 공백이 3개인 2번째 데이터에서 실패함으로 4개인 3번째 데이터를 대상으로는 실행하지 않음

test("sut works", () => {
  for (const source of ["hello  world", "hello   world", "hello    world"]) {
    const actual = sut(source);
    expect(actual).toBe("hello world");
  }
});

//코드의 양은 줄었지만, 품질은 낮아짐

//parameter write test => test.each
//테스트 테이블 작성
//2번째 테스트 케이스가 실패했음을 파악 가능
test.each`
  source              | expected
  ${"hello  world"}   | ${"hello world"}
  ${"hello   world"}  | ${"hello world"}
  ${"hello    world"} | ${"hello world"}
`("sut", ({ source, expected }) => {
  const actual = sut(source);
  expect(actual).toBe(expected);
});

test.each`
  source              | expected
  ${"hello /t world"} | ${"hello world"}
`("contains tab", ({ source, expected }) => {
  const actual = sut(source);
  expect(actual).toBe(expected);
});

describe("given banned word", () => {
  const bannedWord = faker.lorem.word();
  const source = "hello " + bannedWord;
  const expected = "hello " + "*".repeat(bannedWord.length);

  test(`${bannedWord}`, () => {
    const actual = sut(source, { bannedWords: [bannedWord] });
    expect(actual).toBe(expected);
  });
});
