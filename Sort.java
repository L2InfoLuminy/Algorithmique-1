import java.util.ArrayList;

public class Sort
{
  public static void bubbleSort(RandArray array)
  {
    int i = array.getSize() - 1;
    int j = 0;
    
    for(; i > 1; i--)
      for(j = 0; j  < i; j++)
	if( (int) array.get(j) > (int) array.get(j+1) )
	  array.swap(j, j + 1);
  }

  //====== Tri à fusion ======//
  
  public static void fusionSort(RandArray array, int beginning, int end)
  {
    if(beginning + 1 < end + 1)
    {
      int separation = (beginning + end) / 2;

      fusionSort(array, beginning, separation);
      fusionSort(array, separation + 1, end);
      fusion(array, beginning, separation, end);
    }
  }

  public static void fusion(RandArray array, int beginning, int separation, int end)
  {
    // On coupe le tableau en 2
    int sizeLeftArray = separation - beginning + 1;
    int sizeRightArray = end - separation;

    RandArray leftArray = new RandArray(sizeLeftArray);
    RandArray rightArray = new RandArray(sizeRightArray);

    // On remplit chaque sous-tableau
    for(int index = 0; index < sizeLeftArray; index++)
      leftArray.set(index, array.get(beginning + index));

    for(int index = 0; index < sizeRightArray; index++)
      rightArray.set(index, array.get(separation + 1  + index));

    // On reremplit le tableau principal en triant les valeurs à la volée.
    int index;
    int i = 0, j = 0;
    
    for(index = beginning; i < leftArray.getSize() && j < rightArray.getSize(); index++)
    {
      if((int) leftArray.get(i) < (int) rightArray.get(j))
      {
	array.set(index, leftArray.get(i));
	i++;
      }
      else
      {
	array.set(index, rightArray.get(j));
	j++;
      }
    }

    // On s'assure de copier le reste des tableaux
    if(j < rightArray.getSize())
    {
      for(; index < end; index++)
      {
	array.set(index, rightArray.get(j));
	j++;
      }
    }
    else if(i < leftArray.getSize())
    {
      for(; index < end + 1; index++)
      {
	array.set(index, leftArray.get(i));
	i++;
      }
    }

  }

  //====== Tri rapide ======//

  public static void quickSort(RandArray randArray, int beginning, int end)
  {
    if(beginning < end)
    {
      int pivot = beginning;

      // Il faut récupérer la position du pivot s'il a changé de place pendant
      // le partitionnement
      pivot = divide(randArray, beginning, end, pivot);
      quickSort(randArray, beginning, pivot - 1);
      quickSort(randArray, pivot + 1, end);
    }
  }

  public static int divide(RandArray randArray, int beginning, int end, int pivot)
  {
    // Partitionnement par drapeau
    int i = pivot + 1;

    while(i <= end)
    {
      if( (int) randArray.get(i) == (int) randArray.get(pivot) )
	i++;
      else if( (int) randArray.get(i) < (int) randArray.get(pivot) )
      {
	randArray.swap(pivot, i);
	pivot++;
	i++;
      }
      else if( (int) randArray.get(i) > (int) randArray.get(pivot) )
      {
	randArray.swap(i, end);
	end--;
      }
    }
    
    return pivot;
  }

  //==== Tri par tas ====//

  public static void heapSort(RandArray tree, int length)
  {
    for(int node = length / 2; node >= 0; node--)
      sift(tree, node, length);
    for(int node = length; node >= 1; node--)
    {
      tree.swap(node, 0);
      sift(tree, 0, node - 1);
    }
  }
  
  public static void sift(RandArray tree, int node, int length)
  {
    int currentNode = node;
    int nodesSon = 2*currentNode;
    
    //nodesSon et nodesSon+1 sont les deux fils de current_node
    
    while(nodesSon <= length)
    {
      //Trouve le fils le plus grand
      if(nodesSon < length && (int) tree.get(nodesSon) < (int) tree.get(nodesSon + 1))
	nodesSon++;
      
      //Si on trouve on fils plus grand, on échange, on saute au nouvel emplacement
      //et on recommence
      if((int) tree.get(currentNode) < (int) tree.get(nodesSon))
      {
	tree.swap(currentNode, nodesSon);
	currentNode = nodesSon;
	nodesSon = 2*currentNode;
      }
      //Sinon, on sort de la boucle car le noeud a été trié
      else
	nodesSon = length + 1;
    }
  }

  //==== Tri par dénombrement ====//

  public static void printArray(ArrayList<Object> array)
  {
    for(int i = 0; i < array.size(); i++)
      System.out.print((int) array.get(i) + " ");
    System.out.println();
  }
  
  
  public static void initArray(ArrayList<Object> array, int size)
  {
    for(int i = 0; i < size; i++)
      array.add(0);
  }

  public static void countingSort(RandArray randArray, int length)
  {
    ArrayList<Object> occurenceArray = new ArrayList<Object>();
    initArray(occurenceArray, randArray.max() + 1);
    
    for(int i = 0; i < length; i++)
      occurenceArray.set((int) randArray.get(i), (int) occurenceArray.get((int) randArray.get(i)) + 1);
    
    int k = 0;
    for(int i = 0; i < occurenceArray.size(); i++)
      for(int j = 0; j < (int) occurenceArray.get(i); j++)
      {
	randArray.set(k, i);
	k++;
      }
  }
    
  
  
}


