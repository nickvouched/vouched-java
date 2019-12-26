package com.vouched.sdk;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {
  @Test
  public void shouldFailWithInvalidToken() {
    Client client = new Client("invalid");

    try {
      client.getJobs();
      fail("Exception expected");
    } catch (VouchedException e) {
      assertEquals(VouchedError.UNAUTHENTICATED, e.getType());
    }
  }

  @Test
  public void shouldRespondWithJobs() throws VouchedException {
    Client client = new Client(Config.get().getPrivateKey());

    Jobs jobs = client.getJobs();
    assertTrue(jobs.total > 0);
  }

  /*
  @Test
  public void shouldSubmitJob() throws VouchedException {
    Client client = new Client(Config.get().getPrivateKey());

    SubmitJob submitJob = new SubmitJob();
    submitJob.parameters.idPhoto = "1";

    Job job = client.submit(submitJob);
    assertNotNull(job);
  }

   */
}
