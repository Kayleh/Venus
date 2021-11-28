//import com.kayleh.util.ZookeeperClientUtil;
//import org.apache.curator.framework.CuratorFramework;
//import org.junit.*;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * 基础操作测试类
// *
// * @author 有梦想的肥宅
// * @date 2021/8/18
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = CuratorBaseControlDemo.class)
//public class CuratorBaseControlDemo {
//
//    //创建节点【有梦想的肥宅】
//    @Test
//    public void testCreate() throws Exception {
//        CuratorFramework curatorFramework = ZookeeperClientUtil.getCuratorFramework();
//        curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/nodeForJava", "this is value!".getBytes());
//        System.out.println("=========【有梦想的肥宅】节点创建成功========");
//    }
//
//    //获取节点值【有梦想的肥宅】
//    @Test
//    public void testGetData() throws Exception {
//        CuratorFramework curatorFramework = ZookeeperClientUtil.getCuratorFramework();
//        byte[] bytes = curatorFramework.getData().forPath("/nodeForJava");
//        System.out.println("=========【有梦想的肥宅】获取到的节点值：" + new String(bytes) + "========");
//    }
//
//    //更新节点值【有梦想的肥宅】
//    @Test
//    public void testSetData() throws Exception {
//        CuratorFramework curatorFramework = ZookeeperClientUtil.getCuratorFramework();
//        curatorFramework.setData().forPath("/nodeForJava", "changed!".getBytes());
//        byte[] bytes = curatorFramework.getData().forPath("/nodeForJava");
//        System.out.println("=========【有梦想的肥宅】更新后节点的值：" + new String(bytes) + "========");
//    }
//
//    //删除节点【有梦想的肥宅】
//    //PS：guaranteed() 强制删除
//    //PS：deletingChildrenIfNeeded() 删除一个节点，并且递归删除其所有的子节点
//    @Test
//    public void testDelete() throws Exception {
//        CuratorFramework curatorFramework = ZookeeperClientUtil.getCuratorFramework();
//        String pathWithParent = "/nodeForJava";
//        curatorFramework.delete().guaranteed().deletingChildrenIfNeeded().forPath(pathWithParent);
//        System.out.println("=========【有梦想的肥宅】已成功删除节点：" + pathWithParent + "========");
//    }
//
//}
