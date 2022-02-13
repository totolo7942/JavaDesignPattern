package creational_design_pattern;

/**
 * Proxy 패턴을 사용하는 경우에 대해 이야기해 보겠습니다.
 *
 * 복잡하거나 무거운 물체의 단순화된 버전을 원할 때. 이 경우 요청 시 원래 객체를 로드하는 스켈레톤 객체로 나타낼 수 있습니다. 이를 지연 초기화라고도 합니다. 이것은 가상 프록시로 알려져 있습니다.
 * 원래 객체가 다른 주소 공간에 있고 이를 로컬로 표현하려는 경우 . 클라이언트가 로컬 주소 공간에 있는 그대로 액세스하는 동안 연결 생성 및 유지 관리, 인코딩, 디코딩 등과 같은 모든 필수 상용구 작업을 수행하는 프록시를 생성할 수 있습니다. 이것을 원격 프록시라고 합니다.
 * 클라이언트의 액세스 권한을 기반으로 제어된 액세스를 제공하기 위해 원래 기본 개체에 보안 계층을 추가하려는 경우 . 이를 보호 프록시라고 합니다.
 *
 * 객체의 단순화된 버전을 가지거나 객체에 더 안전하게 액세스하려는 경우
 */
public class ProxyPatternMain {
    public static void main(String[] args) {
        A a = new AProxy();
        a.process();
    }
}

interface A {
    void process();
}

class AImpl implements A {

    @Override
    public void process() {
        System.out.println("A implement process");
    }
}

class AProxy implements A {
    private AImpl aimpl;

    @Override
    public void process() {
        if( aimpl == null)
            aimpl = new AImpl();

        aimpl.process();

    }
}