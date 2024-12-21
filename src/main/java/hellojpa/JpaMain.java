package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /*생성*/
            //Member member = new Member();
            //member.setId(1L);
            //member.setName("HelloA");
            //em.persist(member);

            /*조회*/
            //Member findMember = em.find(Member.class, 1L);
            //System.out.println("findMember.Id = " + findMember.getId());
            //System.out.println("findMember.Name = " + findMember.getName());

            /*삭제*/
            //Member findMember = em.find(Member.class, 1L);
            //em.remove(findMember);

            /*수정*/
            //Member findMember = em.find(Member.class, 1L);
            //findMember.setName("HelloJPA");

            /*JPQL*/
            //List<Member> result = em.createQuery("select m from Member as m", Member.class)
            //        .setFirstResult(1)
            //        .setMaxResults(8)
            //        .getResultList();
            //
            //for (Member member : result) {
            //    System.out.println("member = " + member);
            //}

            /*비영속*/
            //Member member = new Member();
            //member.setId(100L);
            //member.setName("HelloJPA");

            /*영속*/
            //System.out.println("Before");
            //em.persist(member);
            //System.out.println("After");
            //
            //Member findMember = em.find(Member.class, 100L);
            //System.out.println("findMember.Id = " + findMember.getId());
            //System.out.println("findMember.Name = " + findMember.getName());

            /*동일성 보장*/
            //Member findMember1 = em.find(Member.class, 100L);
            //Member findMember2 = em.find(Member.class, 100L);
            //System.out.println("result = " + (findMember1 == findMember2));

            /*엔티티 등록 (트랜잭션을 지원하는 쓰기 지연)*/
            //Member member1 = new Member(150L, "A");
            //Member member2 = new Member(160L, "B");
            //
            //em.persist(member1);
            //em.persist(member2);
            //System.out.println("=======================");

            /*엔티티 수정 (변경감지)*/
            //Member member = em.find(Member.class, 150L);
            //member.setName("ZZZZZ");
            //System.out.println("=======================");

            /*플러시*/
            //Member member = new Member(200L, "member200");
            //em.persist(member);
            //
            //em.flush();
            //System.out.println("=======================");

            /*준영속 상태*/
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            //em.detach(member);
            em.clear();

            Member member2 = em.find(Member.class, 150L);

            System.out.println("=======================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
