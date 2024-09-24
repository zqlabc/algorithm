package class030;

/**
 * ClassName: f
 * Package: class030
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/23 15:09
 * @Version 1.0
 */


// 二叉树按层序列化和反序列化
// 测试链接 : https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
public class Code06_LevelorderSerializeAndDeserialize {

    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }

    public static int MAXN = 10001;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;
    // 提交这个类
    // 按层序列化
    public class Codec {


        public String serialize(TreeNode root) {
            StringBuilder builder=new StringBuilder();
            if(root!=null) {
                l=r=0;
                builder.append(root.val+",");
                queue[r++]=root;
                while (l<r){
                    TreeNode cur = queue[l++];
                    if(cur.left!=null){
                        builder.append(cur.left.val+",");
                        queue[r++]=cur.left;
                    }else {
                        builder.append("#,");
                    }
                    if(cur.right!=null){
                        builder.append(cur.right.val+",");
                        queue[r++]=cur.right;
                    }else {
                        builder.append("#,");
                    }
                }
            }
            return builder.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.equals("")) {
                return null;
            }
            String[] nodes = data.split(",");
            int index = 0;
            TreeNode root = generate(nodes[index++]);
            l = 0;
            r = 0;
            queue[r++] = root;
            while (l < r) {
                TreeNode cur = queue[l++];
                cur.left=generate(nodes[index++]);
                cur.right=generate(nodes[index++]);
                if(cur.left!=null){
                    queue[r++]=cur.left;
                }
                if(cur.right!=null){
                    queue[r++]=cur.right;
                }
            }
            return root;
        }

        private TreeNode generate(String val) {
            return val.equals("#") ? null : new TreeNode(Integer.valueOf(val));
        }

    }

}