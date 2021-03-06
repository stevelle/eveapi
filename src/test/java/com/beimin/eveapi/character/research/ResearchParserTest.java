package com.beimin.eveapi.character.research;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.pilot.ResearchAgent;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.ResearchParser;
import com.beimin.eveapi.response.pilot.ResearchResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ResearchParserTest extends FullAuthParserTest {
	public ResearchParserTest() {
		super(ApiPath.CHARACTER, ApiPage.RESEARCH);
	}

	@Test
	public void getResponse() throws ApiException {
		ResearchParser parser = new ResearchParser();
		ResearchResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<ResearchAgent> researchAgents = response.getAll();
		assertNotNull(researchAgents);
		assertEquals(5, researchAgents.size());
		boolean found = false;
		for (ResearchAgent researchAgent : researchAgents) {
			if (researchAgent.getAgentID() == 3012659) {
				found = true;
				assertEquals(11452, researchAgent.getSkillTypeID());
				assertDate(2009, 10, 14, 21, 37, 42, researchAgent.getResearchStartDate());
				assertEquals(111.78, researchAgent.getPointsPerDay(), 0.0001);
				assertEquals(40.9576281249902, researchAgent.getRemainderPoints(), 1E-15);
				break;
			}
		}
		assertTrue("Test agent wasn't found.", found);
	}
}