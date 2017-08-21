package org.sprintdragon.opensource.msgpack;

import org.junit.Test;
import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;
import org.msgpack.template.Template;
import org.msgpack.template.Templates;
import org.msgpack.type.Value;
import org.msgpack.unpacker.Converter;
import org.msgpack.unpacker.Unpacker;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangdi on 17-5-2.
 */
public class TemplateTest {

    /**
     * 可以使用Template来序列化容器比如List和Map，当序列化一个List对象，其中的元素是Integer类型时，创建Template的方法是：
     * <p>
     * Template<List<Integer>> integerTemplate = Templates.tList(Templates.TInteger);
     * <p>
     * 其中tList是Templates的静态方法，TInteger是Templates的静态字段
     *
     * @throws Exception
     */
    @Test
    public void testContainer() throws Exception {
        MessagePack messagePack = new MessagePack();

        Template<List<String>> listTemplate = Templates.tList(Templates.TString);
        Template<Map<String, String>> mapTemplate = Templates.tMap(Templates.TString, Templates.TString);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Packer packer = messagePack.createPacker(outputStream);
        List<String> list = new ArrayList<String>();
        list.add("saolangjian");
        list.add("axiba");
        list.add("woX");
        packer.write(list);

        Map<String, String> map = new HashMap<String, String>();
        map.put("slj", "cz");
        map.put("sg", "cc");
        packer.write(map);

        byte[] bs = outputStream.toByteArray();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(bs);
        Unpacker unpacker = messagePack.createUnpacker(inputStream);
        List<String> seList = unpacker.read(listTemplate);
        System.out.println(seList);
        Map<String, String> seMap = unpacker.read(mapTemplate);
        System.out.println(seMap);
    }

    /**
     * 有些情况下，我们使用的实体类是外部类库中引用的，这时我们不能将@Message注解添加到类声明上，此时就有另一种方法进行操作，使用MessagePack.register方法
     *
     * @throws Exception
     */
    @Test
    public void testRegister() throws Exception {
        Account account = new Account();
        account.setBalance(10.01);
        account.setDetails("xxoo");
        MessagePack messagePack = new MessagePack();
        messagePack.register(Account.class);
        byte[] bs = messagePack.write(account);
        System.out.println(bs.length);
        Account seAccount = messagePack.read(bs, Account.class);
        System.out.println(seAccount);
    }

    /**
     * 为了保证序列化向前兼容，使用@Optional注解对新增加的字段，当反序列化旧版本的数据时，加入@Optional注解的字段就会被忽略

     MessagePack提供了动态类型的功能，通过接口Value来实现动态类型，首先将字节数组序列化为Value类型的对象，然后用converter转化为本身的类型
     * @throws Exception
     */
    @Test
    public void testValue() throws Exception{
        Account account = new Account();
        account.setBalance(10.01);
        account.setDetails("xxoo");
        MessagePack messagePack = new MessagePack();
        messagePack.register(Account.class);
        byte[] bs = messagePack.write(account);
        System.out.println(bs.length);
        Value value = messagePack.read(bs);
        Account seAccount = new Converter(messagePack,value).read(Account.class);
        System.out.println(seAccount);
    }
}
