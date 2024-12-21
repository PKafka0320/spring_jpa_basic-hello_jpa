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
            //생성
            //Member member = new Member();
            //member.setId(1L);
            //member.setName("HelloA");
            //em.persist(member);

            //조회
            //Member findMember = em.find(Member.class, 1L);
            //System.out.println("findMember.Id = " + findMember.getId());
            //System.out.println("findMember.Name = " + findMember.getName());

            //삭제
            //Member findMember = em.find(Member.class, 1L);
            //em.remove(findMember);

            //수정
            //Member findMember = em.find(Member.class, 1L);
            //findMember.setName("HelloJPA");

            //JPQL
            //List<Member> result = em.createQuery("select m from Member as m", Member.class)
            //        .setFirstResult(1)
            //        .setMaxResults(8)
            //        .getResultList();
            //
            //for (Member member : result) {
            //    System.out.println("member = " + member);
            //}

            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            //영속
            System.out.println("Before");
            em.persist(member);
            System.out.println("After");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
