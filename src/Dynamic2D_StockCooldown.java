import java.util.HashMap;
import java.util.Map;

public class Dynamic2D_StockCooldown {
    int[] pricearr;
    Map<String, Integer> cache;
    public int maxProfit(int[] prices) {
        cache = new HashMap<>();
        pricearr = prices;
        return dfs(0, true);
    }

    public int dfs(int index, boolean buying) {
        if (index >= pricearr.length) return 0;
        String key = index + "-" + buying;
        if (cache.containsKey(key)) { return cache.get(key); }

        int cooldown = dfs(index + 1, buying);
        int buyOsell = Integer.MIN_VALUE;

        if (buying) {
            buyOsell = dfs(index + 1, !buying) - pricearr[index];
        } else {
            buyOsell = dfs(index + 2, true) + pricearr[index];
        }

        cache.put(key, Math.max(buyOsell, cooldown));
        return cache.get(key);
    }

    public static void main(String[] args) {
        Dynamic2D_StockCooldown a1 = new Dynamic2D_StockCooldown();
        int[] prices = {1,2,3,0,2};
        System.out.println(a1.maxProfit(prices));
    }
}
