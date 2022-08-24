function search_word(){
    const word=document.getElementById("word");
    const meaning=document.getElementById("meaning")
    let wordList={
            "abstract":"추상의",
            "accumulator":"누산기",
            "address":"주소",
            "allocate":"할당하다",
            "annotation":"주석",
            "argument":"인자",
            "arithmetic":"산술,연산,계산",
            "array":"배열",
            "assert":"단언하다",
            "assign":"할당",
            "attribute":"속성",
            "auth":"인증",
            "base number":"밑수",
            "batch":"일괄처리",
            "binary":"이진, 바이너리",
            "Boolean":"불린, 불, 부울",
            "bound":"바인드된, 한정",
            "build":"빌드, 빌드하다, 구축하다",
            "byte padding":"바이트 패딩",
            "cache":"캐시",
            "character":"문자",
            "class":"클래스, 분류",
            "clone":"복제하다",
            "column":"칼럼,열",
            "columnar databases":"칼럼형 데이터베이스",
            "combinational logic":"조합 논리",
            "command":"명령하다",
            "comment":"주석, 설명, 댓글",
            "commit" :"파일 및 폴더의 추가/변경 사항을 저장소에 등록",
            "compiler":"소스 코드를 머신 코드로 변경하는 프로그램",
            "component":"컴포넌트, 구성 요소",
            "composition":"합성, 구성",
            "concrete":"구체의",
            "constructor":"생성자",
            "convention":"관례, 규칙",
            "declaration":"선언",
            "default":"기본값, 디폴트",
            "dereference":"역참조",
            "deserialization":"역직렬화",
            "destruction":"폐기",
            "encapsulation":"캡슐화",
            "entity":"개체, 엔티티",
            "execution":"실행",
            "exponent":"지수",
            "foreign key":"외래키",
            "generator":"제너레이터",
            "global":"전역, 글로벌",
            "immutable":"변경 불가능한, 불변의",
            "implement":"구현하다",
            "inheritance":"상속",
            "instance":"인스턴스",
            "integrity":"무결성",
            "interpreter":"인터프리터",
            "local variable":"지역 변수",
            "merge":"병합하다",
            "modifier":"변경자",
            "mutable":"변경 가능한",
            "parameter":"매개변수",
            "preprocessor":"전처리기",
            "primary key":"기본 키",
            "property":"속성",
            "recursive":"재귀적인",
            "repository":"저장소",
            "secure shell":"보안 셸",
            "serialization":"직렬화",
            "setter":"설정자",
            "significant digits":"유효숫자",
            "stateless":"상태가 없는, 상태를 저장하지 않는",
            "substitution":"교체",
            "validation":"검증"
        }

    if (wordList[word.value]){
        meaning.value=wordList[word.value];
    }else{
        alert("단어가 등록되어 있지 않습니다😥");

    }

    return false;
}

function clear_word(){
    const word=document.getElementById("word");
    const meaning=document.getElementById("meaning")
    word.value="";
    meaning.value="";
}

