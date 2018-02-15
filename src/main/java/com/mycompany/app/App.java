package com.mycompany.app;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static boolean control(ArrayList<Integer> array1, Integer[] array2,Integer index1, Integer index2) {
        	    	if (array1 == null) return false;
        	    	if (array2 == null) return false;
                    if (index1 == null) return false;
                    if (index2 ==  null) return false;
        	    	
        	    	if(array1.isEmpty() || array2.length==0)
             			return false;
                   
     
        	    	
        	    	if( index1<0 || index2<0 ||index2<index1 || index1>=array1.size() || index2>=array1.size() ||  index1>=array2.length ||index2>=array2.length  )
        	    		return false;
        	    	
        	    	for(int i=index1; i<=index2; i++){
        	    		if(array2[i].intValue()!=array1.get(i))
        	    			return false;
        	    	}
        	    	
        	    	return true;
        	      }
        
        public static void main(String[] args) {
                        port(getHerokuAssignedPort());

                        get("/", (req, res) -> "Hello, World");

                        post("/compute", (req, res) -> {
                            //System.out.println(req.queryParams("input1"));
                            //System.out.println(req.queryParams("input2"));

                            String input1 = req.queryParams("input1");
                            java.util.Scanner sc1 = new java.util.Scanner(input1);
                            sc1.useDelimiter("[;\r\n]+");
                            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
                            while (sc1.hasNext())
                            {
                                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                                inputList.add(value);
                            }
                            System.out.println(inputList);
                            
                            String input2 = req.queryParams("input2");
                            java.util.Scanner sc2 = new java.util.Scanner(input2);
                            sc2.useDelimiter("[;\r\n]+");
                            java.util.ArrayList<Integer> arr = new java.util.ArrayList<>();
                            int i=0;
                            while (sc2.hasNext())
                            {   
                                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                                arr.add(value);
                                i++;
                            }
                            
                            Integer[] inputList2=new Integer[i];
                            for (int k=0; k<arr.size(); k++){
                                inputList2[k]=arr.get(k);
                            }
                            
                            Integer input3AsInt=0;
                            String input3 = req.queryParams("input3").replaceAll("\\s","");
                            if(input3.equals(""))
                            input3AsInt = -1;
                            else
                            input3AsInt = Integer.parseInt(input3);
                            
                            Integer input4AsInt=0;
                            String input4 = req.queryParams("input4").replaceAll("\\s","");
                            if(input4.equals(""))
                            input4AsInt = -1;
                            else
                            input4AsInt = Integer.parseInt(input4);
                            

                            boolean result = App.control(inputList, inputList2 , input3AsInt,input4AsInt);

                         Map map = new HashMap();
                            map.put("result", result);
                            return new ModelAndView(map, "compute.mustache");
                        }, new MustacheTemplateEngine());


                        get("/compute",
                                (rq, rs) -> {
                                    Map map = new HashMap();
                                    map.put("result", "not computed yet!");
                                    return new ModelAndView(map, "compute.mustache");
                                },
                               new MustacheTemplateEngine());
        }

                static int getHerokuAssignedPort() {
                        ProcessBuilder processBuilder = new ProcessBuilder();
                        if (processBuilder.environment().get("PORT") != null) {
                                return Integer.parseInt(processBuilder.environment().get("PORT"));
                        }
                        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
                }

}