class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> recipeSet = new HashSet<>();
        for (String r : recipes) recipeSet.add(r);
        int[] indegree = new int[recipes.length];
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            indegree[i] = ingredients.get(i).size();
            for (String ing : ingredients.get(i)) {
                if (!map.containsKey(ing)) map.put(ing, new ArrayList<Integer>());
                map.get(ing).add(i);
            }
        }
        List<String> res = new ArrayList<>();
        Queue<String> que = new LinkedList<>();
        for (String supply : supplies) que.offer(supply);
        while (!que.isEmpty()) {
            String ing = que.poll();
            if (recipeSet.contains(ing)) res.add(ing);
            if (!map.containsKey(ing)) continue;            
            for (int idx : map.get(ing)) {
                indegree[idx]--;
                if (indegree[idx] == 0) que.offer(recipes[idx]);
            }
        }
        return res;
    }
}