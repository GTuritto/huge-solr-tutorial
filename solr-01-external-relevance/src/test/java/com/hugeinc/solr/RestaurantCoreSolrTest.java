package com.hugeinc.solr;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.solr.SolrTestCaseJ4;
import org.apache.solr.client.solrj.request.JavaBinUpdateRequestCodec;
import org.apache.solr.client.solrj.request.JavaBinUpdateRequestCodec.StreamingUpdateHandler;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.common.SolrInputDocument;
import org.junit.BeforeClass;
import org.junit.Ignore;

import com.google.common.collect.Lists;

@Ignore
public class RestaurantCoreSolrTest extends SolrTestCaseJ4 {

  @BeforeClass
  public static void beforeClass() throws Exception {
    initCore("solrconfig.xml", "schema.xml", "solr/restaurantcore");
    creatTestRestaurantData();
  }

  private static void creatTestRestaurantData() {

  }

  @Override
  public void setUp() throws Exception {
    super.setUp();
    /*
    JavaBinUpdateRequestCodec codec = new JavaBinUpdateRequestCodec();
    File restaurants = new File("src/test/resources/restaurantData.javabin");
    FileInputStream fis = new FileInputStream(restaurants);

    final List<SolrInputDocument> doc = Lists.newArrayList();
    UpdateRequest request2 = codec.unmarshal(fis, new StreamingUpdateHandler() {
      @Override
      public void update(SolrInputDocument document, UpdateRequest req) {
        req.add(document);
        doc.add(document);
      }
    });
    assertU(request2.getXML());
    assertU(commit());
    */
  }

}
