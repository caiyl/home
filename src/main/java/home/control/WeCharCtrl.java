package home.control;

import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeCharCtrl {
	@RequestMapping("/wechar.do")
	public void wechar(HttpServletRequest request, HttpServletResponse response) {

		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		
		try {

			PrintWriter out = response.getWriter();
			if (null != signature && null != timestamp && null != nonce && null != echostr) {/* 接口验证 */

				if (!"".equals(echostr)) {//验证echostr
					out.write(echostr); // 请求验证成功，返回随机码
				} else {
					out.write("");//请求验证失败
				}
				out.flush();
				out.close();
			} else {
				//处理消息
				doMessage( request,  response);
			}
		} catch (Exception e) {

		}
	}

	/* 消息处理 */
	private void doMessage(HttpServletRequest request, HttpServletResponse response) {
		/* 消息处理 */

		Object aa = request.getAttribute("signature");

		System.out.println("----------post---------------");
		try {
			InputStream is = request.getInputStream();
			// 取HTTP请求流长度
			int size = request.getContentLength();
			// 用于缓存每次读取的数据
			byte[] buffer = new byte[size];
			// 用于存放结果的数组
			byte[] xmldataByte = new byte[size];
			int count = 0;
			int rbyte = 0;
			// 循环读取
			while (count < size) {
				// 每次实际读取长度存于rbyte中
				rbyte = is.read(buffer);
				for (int i = 0; i < rbyte; i++) {
					xmldataByte[count + i] = buffer[i];
				}
				count += rbyte;
			}
			is.close();
			String requestStr = new String(xmldataByte, "UTF-8");
			Document doc = DocumentHelper.parseText(requestStr);
			Element rootElt = doc.getRootElement();
			String content = rootElt.elementText("Content");
			String toUserName = rootElt.elementText("ToUserName");
			String fromUserName = rootElt.elementText("FromUserName");
			// 得到所有的有用数据
			System.out.println(content + ":" + toUserName + ":" + fromUserName);
			// 文本消息
			if ("text".equals(content)) {
				String responseStr = "<xml>";
				responseStr += "<ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>";
				responseStr += "<FromUserName><![CDATA[" + toUserName + "]]></FromUserName>";
				responseStr += "<CreateTime>" + System.currentTimeMillis() + "</CreateTime>";
				responseStr += "<MsgType><![CDATA[text]]></MsgType>";
				responseStr += "<Content>输入text或者news返回相应类型的消息，另外推荐你关注 '红色石头'（完全采用Java完成），反馈和建议请到http://wzwahl36.net</Content>";
				responseStr += "<FuncFlag>0</FuncFlag>";
				responseStr += "</xml>";
				response.getWriter().write(responseStr);
			}
			// 图文消息
			else if ("news".equals(content)) {
				String responseStr = "<xml>";
				responseStr += "<ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>";
				responseStr += "<FromUserName><![CDATA[" + toUserName + "]]></FromUserName>";
				responseStr += "<CreateTime>" + System.currentTimeMillis() + "</CreateTime>";
				responseStr += "<MsgType><![CDATA[news]]></MsgType>";
				responseStr += "<Content><![CDATA[]]></Content>";

				responseStr += "<ArticleCount>2</ArticleCount>";

				responseStr += "<Articles>";
				responseStr += "<item>";
				responseStr += "<Title><![CDATA[图文消息——红色石头]]></Title>";
				responseStr += "<Discription><![CDATA[图文消息正文——红色石头]]></Discription>";
				responseStr += "<PicUrl><![CDATA[http://redstones.sinaapp.com/res/images/redstones_wx_258.jpg]]></PicUrl>";
				responseStr += "<Url><![CDATA[http://redstones.sinaapp.com/]]></Url>";
				responseStr += "</item>";

				responseStr += "<item>";
				responseStr += "<Title><![CDATA[图文消息——红色石头]]></Title>";
				responseStr += "<Discription><![CDATA[图文消息正文——红色石头]]></Discription>";
				responseStr += "<PicUrl><![CDATA[http://redstones.sinaapp.com/res/images/redstones_wx_258.jpg]]></PicUrl>";
				responseStr += "<Url><![CDATA[http://redstones.sinaapp.com/]]></Url>";
				responseStr += "</item>";

				responseStr += "</Articles>";
				responseStr += "<FuncFlag>1</FuncFlag>";
				responseStr += "</xml>";
				response.getWriter().write(responseStr);
			}
			// 不能识别
			else {
				String responseStr = "<xml>";
				responseStr += "<ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>";
				responseStr += "<FromUserName><![CDATA[" + toUserName + "]]></FromUserName>";
				responseStr += "<CreateTime>" + System.currentTimeMillis() + "</CreateTime>";
				responseStr += "<MsgType><![CDATA[text]]></MsgType>";
				responseStr += "<Content>hello world http://wzwahl36.net</Content>";
				responseStr += "<FuncFlag>0</FuncFlag>";
				responseStr += "</xml>";
				response.getWriter().write(responseStr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
