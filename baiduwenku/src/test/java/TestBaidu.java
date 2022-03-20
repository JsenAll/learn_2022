import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jasen.crawler.HttpUtils;
import org.junit.Test;


public class TestBaidu {
    public static void main(String[] args) throws  InterruptedException {

        String cookie = "PSTM=1604106135; BIDUPSID=DBB78032C6DEC68500FF69CC48D77A56; __yjs_duid=1_dcac5da632c1b8c0cfed54df74e3ba951626091061731; BAIDUID=2316C29DAA5EA146D027790B2CFB32AE:FG=1; Hm_lvt_d8bfb560f8d03bbefc9bdecafc4a4bf6=1644632206; BDUSS=9qTHJhRWVNNVFrbXlkMVBNUGdSUHZIZGtLdkJkWjhnTmJZU3ZsejQwTXcweTVpRVFBQUFBJCQAAAAAAAAAAAEAAAAs55NruqPJz9K71fO357b5AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADBGB2IwRgdiU2; BDUSS_BFESS=9qTHJhRWVNNVFrbXlkMVBNUGdSUHZIZGtLdkJkWjhnTmJZU3ZsejQwTXcweTVpRVFBQUFBJCQAAAAAAAAAAAEAAAAs55NruqPJz9K71fO357b5AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADBGB2IwRgdiU2; BAIDUID_BFESS=2316C29DAA5EA146D027790B2CFB32AE:FG=1; _dd_s=logs=1&id=552e19d0-05f0-4d8b-9fa5-33b95e8640b2&created=1647743602343&expire=1647744596548";
        HttpUtils httpUtils = new HttpUtils();

        int count = 0;

        for (int i = 9; i < 160; i++) {
            String content  = httpUtils.doGetHtml("https://cuttlefish.baidu.com/nshop/doc/getlist?sub_tab=1&pn={0}&rn=10&query=&doc_id_str=&time_range=".replace("{0}",i+""),cookie);
            JSONObject jsonObject = JSONObject.parseObject(content).getJSONObject("data");
            String token  = String.valueOf(jsonObject.get("token"));
            JSONArray doc_list = jsonObject.getJSONArray("doc_list");
            if (doc_list.size() == 0) continue;
            for (Object o : doc_list) {
                JSONObject doc = (JSONObject) o;
                String title = (String) doc.get("title");
                String doc_id = (String) doc.get("doc_id");
                String doc_status = doc.get("doc_status")+"";
                if ("4".equals(doc_status)){

                    String delUrl ="https://cuttlefish.baidu.com/user/submit/newdocdelete?token={token}&new_token={token}&fold_id_str=&doc_id_str={doc_id}&skip_fold_validate=1";
                    Thread.sleep(10000);
                    delUrl= delUrl.replace("{token}",token).replace("{doc_id}",doc_id);
//                    System.out.println(delUrl);
                    String content22= httpUtils.doGetHtml(delUrl,cookie);
//                    System.out.println(title+":"+doc_id+" "+doc_status+ "" +content22);

                }
                if ("2".equals(doc_status)){
                    count = count +1;
                    String URL = "https://tanbi.baidu.com/h5stbusiness/browse/jumpdownload?fromKey=wkst223_readview&docId={docId}&ustrId=34b1522bc850ad02de804174";
                    System.out.println("doc_id_"+count+":"+URL.replace("{docId}",doc_id));

                }

            }
//            if (count>50)break;

            Thread.sleep(10000);
        }

    }
    @Test
    public void test(){
        String cookie = "BAIDUID=EE2D58AF8A7EDD1A9C91457C0E90EA78:FG=1; BIDUPSID=EE2D58AF8A7EDD1A9C91457C0E90EA78; PSTM=1552569424; __yjs_duid=1_c05f672de2656e81231c144fb396e06c1625041799339; Hm_lvt_d8bfb560f8d03bbefc9bdecafc4a4bf6=1632316857; BAIDU_WISE_UID=wapp_1645187950708_403; BAIDUID_BFESS=5255DD9045DCA3880252E3A42BD50BD1:FG=1; BDUSS=mVCdDh5WDB1RkNjMDY1ME92ZGhzZ1p0cWhjTllRLS1CdFVPZ2dUdlFhSGp5VDFpRVFBQUFBJCQAAAAAAAAAAAEAAADPvLkWzrHXsMTjtcTDwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOM8FmLjPBZib; BDUSS_BFESS=mVCdDh5WDB1RkNjMDY1ME92ZGhzZ1p0cWhjTllRLS1CdFVPZ2dUdlFhSGp5VDFpRVFBQUFBJCQAAAAAAAAAAAEAAADPvLkWzrHXsMTjtcTDwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOM8FmLjPBZib";
        HttpUtils httpUtils = new HttpUtils();
        String content  = httpUtils.doGetHtml("https://cuttlefish.baidu.com/nshop/doc/getlist?sub_tab=1&pn={0}&rn=10&query=&doc_id_str=&time_range=".replace("{0}",100+""),cookie);
        JSONObject jsonObject = JSONObject.parseObject(content).getJSONObject("data");
        String token  = String.valueOf(jsonObject.get("token"));
        JSONArray doc_list = jsonObject.getJSONArray("doc_list");
        System.out.println();

    }

}
