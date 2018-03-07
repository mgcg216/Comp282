
package Graph;

////////////////////////////////////////////////////////////////

import java.io.IOException;

public class DistPar extends PathApp             // distance and parent
   {                      // items stored in sPath array
   public int distance;   // distance from start to this vertex
   public int parentVert; // current parent of this vertex
// -------------------------------------------------------------
   public DistPar(int pv, int d)  // constructor
      throws IOException {
      distance = d;
      parentVert = pv;
      }
// -------------------------------------------------------------
   }  // end class DistPar
///////////////////////////////////////////////////////////////