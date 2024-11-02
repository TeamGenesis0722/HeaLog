package Genesis.healog.repogitory;

import Genesis.healog.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 동시성 문제로 무슨 해시맵 써야 함
    private static long sequence = 0L; // 0, 1, 2 key 값 생성 -> 동시성 문제 -> 어텀 롱


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String Name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(Name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
