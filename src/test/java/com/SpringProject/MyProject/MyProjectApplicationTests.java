package com.SpringProject.MyProject;

import com.SpringProject.MyProject.others.JoinedTable.JTInstructorRepository;
import com.SpringProject.MyProject.others.JoinedTable.JT_Instructor;
import com.SpringProject.MyProject.others.MappedSuperClass.MSCInstructorRepository;
import com.SpringProject.MyProject.others.MappedSuperClass.MSC_Instructor;
import com.SpringProject.MyProject.others.MappedSuperClass.MSC_User;
import com.SpringProject.MyProject.others.SingleTable.STInstructorRepository;
import com.SpringProject.MyProject.others.SingleTable.STMentorRepository;
import com.SpringProject.MyProject.others.SingleTable.ST_Instructor;
import com.SpringProject.MyProject.others.SingleTable.ST_Mentor;
import com.SpringProject.MyProject.others.TablePerClass.TPCInstructorRepository;
import com.SpringProject.MyProject.others.TablePerClass.TPC_Instructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.OpAnd;

import java.util.Optional;

@SpringBootTest
class MyProjectApplicationTests {
	@Autowired
	MSCInstructorRepository mscInstructorRepository;
	@Autowired
	TPCInstructorRepository tpcInstructorRepository;
	@Autowired
	STInstructorRepository stInstructorRepository;
	@Autowired
	STMentorRepository stMentorRepository;
	@Autowired
	JTInstructorRepository jtInstructorRepository;

	@Test
	void contextLoads() {
	}
	@Test
	void checkMStype(){
		MSC_Instructor mscInstructor = new MSC_Instructor();
		mscInstructor.setId(1L);
		mscInstructor.setAge(22);
		mscInstructor.setDepartment("hr");
		mscInstructor.setName("azamd");
		mscInstructor.setRating(5);
		mscInstructorRepository.save(mscInstructor);

		Optional<MSC_Instructor> mscInstructor1 = mscInstructorRepository.findById(2L);
		System.out.println(mscInstructor1.get().getName());
	}
	@Test
	void checkTPCtype(){
		TPC_Instructor tpcInstructor = new TPC_Instructor();
		tpcInstructor.setId(21L);
		tpcInstructor.setDepartment("sw2");
		tpcInstructor.setName("sukesh");
		tpcInstructor.setRating(4);
		tpcInstructor.setAge(26);
		tpcInstructorRepository.save(tpcInstructor);

	}
	@Test
	void checkSTtype(){
		ST_Instructor stInstructor = new ST_Instructor();
		stInstructor.setName("hiran");
		stInstructor.setDepartment("hw");
		stInstructor.setAge(25);
		stInstructor.setRating(5);

		ST_Mentor stMentor = new ST_Mentor();
		stMentor.setName("mentor1");
		stMentor.setAge(33);
		stMentor.setAddress("addr1");
		stMentor.setExperience(3);
		stInstructorRepository.save(stInstructor);
		stMentorRepository.save(stMentor);

	}
	@Test
	void checkJTtype(){
		JT_Instructor jtInstructor = new JT_Instructor();
		jtInstructor.setDepartment("hr");
		jtInstructor.setName("lokesh");
		jtInstructor.setAge(24);
		jtInstructor.setRating(5);
		jtInstructorRepository.save(jtInstructor);
	}

}
