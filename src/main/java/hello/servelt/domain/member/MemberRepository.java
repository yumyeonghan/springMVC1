package hello.servelt.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    //MemberRepository 를 new 로 객체 생성을 많이해도 static 이기 때문에 딱 하나만 생긴다.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence=0L;

    //싱글톤, 만들때는 private 로 생성자 막아준다.
    private static final MemberRepository instance =new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository(){

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
