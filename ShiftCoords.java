import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.lang.ArrayUtils;
import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;
import java.lang.*;
import java.util.*;
 
public class ShiftCoords {
	static OctaveDouble coordinates;
	public static void main(String[] args) throws Exception {

	String csvFile = "data/simData.csv";
	BufferedReader br = null;
	BufferedReader lr = null;
	String line = "";
	String line1 = "";
	String cvsSplitBy = ",";
 	
	//Obtained from summary after running SIFE generalization
	String[] SUCCESSFUL =  {"c15","c219","c328","c406","c127","c155","c49","c77","c48","c451","c373","c51","c354","c129","c317","c214","c180","c322","c225","c37","c118","c21","c26","c94","c74","c420","c447","c125","c122","c59","c307","c371","c267","c381","c62","c306","c261","c52","c178","c330","c139","c54","c212","c201","c189","c380","c360","c259","c144","c374","c44","c313","c284","c448","c320","c368","c272","c327","c199","c149","c278","c143","c357","c113","c378","c305","c121","c152","c222","c182","c141","c226","c193","c170","c130","c279","c111","c361","c362","c289","c300","c174","c311","c20","c75","c382","c407","c5","c153","c89","c296","c252","c72","c55","c173","c140","c38","c202","c200","c42","c238","c57","c61","c332","c145","c326","c402","c229","c117","c250","c132","c47","c100","c14","c358","c184","c340","c147","c213","c404","c364","c309","c401","c314","c3","c316","c264","c110","c395","c160","c69","c372","c356","c292","c169","c71","c240","c223","c255","c269","c46","c301","c119","c323","c24","c157","c271","c260","c277","c295","c13","c218","c136","c31","c167","c325","c346","c405","c351","c109","c93"};
	String[] FAILED =  {"c242","c367","c135","c68","c177","c243","c137","c241","c237","c78","c18","c216","c1","c399","c163","c17","c230","c436","c4","c232","c103","c282","c146","c353","c228","c80","c426","c355","c283","c268","c430","c126","c429","c195","c27","c188","c154","c120","c388","c84","c423","c324","c248","c30","c66","c217","c310","c288","c290","c35","c142","c308","c22","c172","c164","c150","c432","c67","c171","c227","c156","c440","c275","c128","c266","c211","c453","c385","c262","c379","c369","c148","c124","c273","c387","c441","c95","c186","c424","c58","c208","c270","c363","c439","c231","c97","c315","c176","c34","c256","c79","c185","c87","c438","c318","c82","c274","c85","c41","c452","c175","c206","c425","c352","c207","c394"};
	String[] OVERGENERALIZED =  {"c159","c233","c138","c410","c347","c359","c73","c133","c92","c131","c60","c403","c291","c335","c400","c56","c19","c392","c415","c187","c192","c450","c412","c396","c319","c338","c428","c112","c337","c442","c115","c343","c297","c168","c191","c421","c246","c411","c134","c91","c443","c416","c239","c294","c408","c40","c210","c2","c104","c435","c10","c434","c398","c422","c339","c23","c162","c81","c254","c43","c390","c312","c341","c287","c53","c90","c105","c99","c70","c446","c334","c384","c348","c377","c98","c102","c107","c285","c333","c106","c258","c449","c76","c431","c29","c83","c190","c36","c281","c418","c6","c444","c45","c8","c433","c299","c158","c427","c220","c265","c389","c65","c183","c209","c249","c151","c236","c25","c32","c196","c161","c375","c123","c331","c302","c221","c286","c64","c409","c33","c336","c224","c293","c245","c345","c247","c235","c28","c198","c251","c445","c257","c179","c437","c303","c417","c329","c203","c114","c88","c96","c244","c276","c304","c215","c108","c116","c63","c391","c370","c419","c166","c50","c9","c101","c386","c366","c165","c263","c181","c413","c7","c39","c298","c197","c393","c194","c414","c365","c350","c383","c0","c16","c205","c11","c342","c344","c86","c204","c234","c349","c12","c321","c397","c253","c280","c376"};
	String[] OVERGENERALIZEDWITHVALIDSUBSET =  {"c359","c291","c56","c192","c115","c421","c134","c435","c23","c43","c390","c105","c348","c258","c431","c36","c281","c418","c444","c151","c236","c25","c196","c375","c33","c28","c303","c88","c276","c108","c391","c166","c9","c7","c393","c194","c0","c16","c11"};

	try {
		br = new BufferedReader(new FileReader(csvFile)); //Read csv as it is from input folder
		lr = new BufferedReader(new FileReader(csvFile));
		ArrayList<Double> sims_list = new ArrayList<Double>();
		String[] labels = new String[0];
		String[] updLabArray = new String[0];
		int[] commits = new int[0];
		int[] commitArray = new int[0];
		String[] sim = new String[0];
		String[] label = new String[1];
		int[] comit = new int[0];

		while ((line = br.readLine()) != null) 
		{
			sim = line.split(cvsSplitBy);
			label = new String [1];
			label[0] = sim[sim.length-1];
			comit = new int[1];
			comit[0] = Integer.parseInt(sim[0]);
			updLabArray = (String[])ArrayUtils.addAll(labels, label);
			labels = updLabArray;
			commitArray = ArrayUtils.addAll(commits, comit);
			commits = commitArray;
		}

		ArrayList<Integer> indx = new ArrayList<Integer>();
		for(int i=0; i<labels.length; ++i)
			{
			if(Arrays.asList(OVERGENERALIZED).contains(labels[i]) || Arrays.asList(SUCCESSFUL).contains(labels[i]))
			indx.add(i);
			}
		Integer[] OVERG_INDICES = (Integer[])indx.toArray(new Integer[indx.size()]);
		
		while((line1 = lr.readLine()) != null)
		{
			sim = line1.split(cvsSplitBy);//'this' row
//		Pick rows containing OVERGEN_VALID + SUCC only
			if(Arrays.asList(OVERGENERALIZED).contains(sim[sim.length-1]) || Arrays.asList(SUCCESSFUL).contains(sim[sim.length-1]))
				{
//				System.out.print(sim[0]+",");
				for (int i = 0; i < sim.length - 2; ++i)//ignore 1st and last columns
					{ 
					if(ArrayUtils.contains(OVERG_INDICES, i))//Pick corresponding cols
						{
						sims_list.add(Double.parseDouble(sim[i+1]));
//						System.out.print(sim[i+1]+",");//sim[1] to sim[sim.length-3+1]
						}	
					}
//			System.out.println(sim[sim.length-1]);
			}
		}

	Double[] sims = (Double[])sims_list.toArray(new Double[sims_list.size()]);
	double[] simArray = ArrayUtils.toPrimitive(sims);

	ArrayList<String> foo = new ArrayList<String>();
	ArrayList<Integer> bar = new ArrayList<Integer>();
	for(int i=0; i<labels.length; ++i)
		{
		if(Arrays.asList(OVERGENERALIZED).contains(labels[i]) || Arrays.asList(SUCCESSFUL).contains(labels[i])){
		foo.add(labels[i]);
		bar.add(commits[i]);}
		}
	String[] labelArray = foo.toArray(new String[foo.size()]);
	Integer[] commit = (Integer[])bar.toArray(new Integer[bar.size()]);

	String[] classAttr = new HashSet<String>(Arrays.asList(labelArray)).toArray(new String[0]);//Unique labels for class attribute

	int lens = (int)Math.sqrt(simArray.length);

//	Process in octave
	OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();
	OctaveDouble matA = new OctaveDouble(simArray, lens, lens);//only send OVERGENERALIZED + SUCC to octave
	octave.put("a", matA);
	octave.eval("D = 1 - a;");
	octave.eval("options.dims = 1:3;");
	octave.eval("[Y, R, E] = Isomap(D, 'epsilon', 7, options);");
	octave.eval("coords = Y.coords{3,1};");
	coordinates = (OctaveDouble) octave.get("coords");

	ArrayList<Double> new_coord = new ArrayList<Double>();

	System.out.println("");
	System.out.println("%%****************************	TRAINING SET for STEP 2:	*************");
	System.out.println("%%===============================================================================");
	System.out.println("@relation mlTrainStep2");
	System.out.println("");
	System.out.println("@attribute 1st_coord numeric");
	System.out.println("@attribute 2nd_coord numeric");
	System.out.println("@attribute 3rd_coord numeric");

//	TODO: Will only use overgeneralized groups that are now good to train for outlier detection
//	TODO: Will shift the remaining overgeneralized groups to the origin just as below to obtain the test set

	System.out.print("@attribute @@class@@ {");
	for(int i = 0 ; i < classAttr.length ; ++i) 
		{
			if(Arrays.asList(OVERGENERALIZED).contains(classAttr[i]))
			System.out.print(classAttr[i] + ",");
		}
	System.out.println("}");
	System.out.println("");
	System.out.println("@data");

	for(int i=1; i<OVERGENERALIZED.length + 1; ++i)
	{
	double l1st_avg = 0.0;
	double l2nd_avg = 0.0;
	double l3rd_avg = 0.0;
	int count = 0;

	for(int j = 1; j < labelArray.length + 1; ++j)
	{
	String str1 = labelArray[j-1];
	String str2 = OVERGENERALIZED[i-1];
							
	if(str1.equals(str2))
		{
			l1st_avg += coordinates.get(1,j);
			l2nd_avg += coordinates.get(2,j);
			l3rd_avg += coordinates.get(3,j);
			count += 1;
		}
	}

	l1st_avg = l1st_avg/count; 
	l2nd_avg = l2nd_avg/count;
	l3rd_avg = l3rd_avg/count;

	Point mid = new Point(l1st_avg, l2nd_avg, l3rd_avg);

	for(int m = 1; m < labelArray.length + 1; ++m){
	String str1 = labelArray[m-1];
	String str2 = OVERGENERALIZED[i-1];
	if(str1.equals(str2)){
		Point shifted = Point.shift(mid, coordinates.get(1,m), coordinates.get(2,m), coordinates.get(3,m));
		new_coord.add(shifted.coord1);
		new_coord.add(shifted.coord2);
		new_coord.add(shifted.coord3);//TODO: Change labelArray below to reflect outlier/good commits after generalization
		System.out.println(commit[m-1] + "," + shifted.coord1 + "," + shifted.coord2 + "," + shifted.coord3 + "," + labelArray[m-1]); 				}
		}
	}

// 	To octave for plotting
	Double[] new_coords = (Double[])new_coord.toArray(new Double[new_coord.size()]);
	double[] coord_new = ArrayUtils.toPrimitive(new_coords);

	OctaveDouble shift_mat = new OctaveDouble(coord_new, OVERGENERALIZED.length, 3);
	octave.put("b", shift_mat);
	octave.eval("b");
	octave.eval("plot3(b(:,1),b(:,2),b(:,3))");	

//	octave.close();
	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
				}
			}
		}
	}
}

class Point
{ 
	 public double coord1, coord2, coord3;
	 public Point (double coord1, double coord2, double coord3) {
	     this.coord1 = coord1;
	     this.coord2 = coord2;
	     this.coord3 = coord3;
	 }

	static Point shift (Point other, double c1, double c2, double c3) {
	    return new Point(c1 - other.coord1, c2 - other.coord2, c3 - other.coord3);
	}
}   
