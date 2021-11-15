package creational_design_pattern;

/**
 * Creational Pattern : https://arunprashanth6.medium.com/a-complete-guide-on-design-pattern-in-java-2b80fbf088ce
 * Instance 생성 비용을 최소화 하면서, 생성된 인스턴스와 동일하거나 확장이 필요할때 사용
 * 장점
 * - 서브 클래싱의 필요성을 줄입니다.
 * - 객체 생성의 복잡성을 숨깁니다.
 * - 클라이언트는 어떤 유형의 객체인지 모른 채 새로운 객체를 얻을 수 있습니다.
 * - 런타임에 객체를 추가하거나 제거할 수 있습니다.
 *
 * - 클래스가 런타임에 인스턴스화 되는 경우
 * - 객체 생성비용이 비싸거나 복잡한 경우
 * - 응용 프로그램의 클래스 수를 최소로 유지하려는 경우
 * - 클라이언트 응용프로그램이 객체 생성 및 표현을 인식하지 못하는 경우
 *
 * ex) 1 DB를 통해 가져오는 instance를 통해 추가 삭제를 할 경우 다시 DB를 통하는 것이 아닌 복사본을 통해 가져온다.
 *
 *
 * 단점: 복잡도가 올라갈수 있음.
 *
 * Prototype Patter vs Abstract Factory 의 차이점
 */
public class PrototypePatternMain {
}
