
public class Buscas {

  public static int pesquisaSequencial(int[] pSeq, int pInicio, int pFim, int pVal) {
    for (int indice = pInicio; indice <= pFim; indice++) {
      if (pSeq[indice] == pVal) {
        return indice;
      }
    }
    return -1;
  }

  public static int buscaSeqOrdenada(int[] pSeq, int pInicio, int pFim, int pVal) {
    int indice;
    for (indice = pInicio; indice <= pFim; indice++) {
      if (pSeq[indice] >= pVal)
        break;
    }
    if (indice <= pFim && pSeq[indice] == pVal)
      return indice;
    else
      return -1;
  }

  public static int pesquisaBinaria(int[] pSeq, int pInicio, int pFim, int pVal) {
    int min = pInicio;
    int max = pFim;
    while (min <= max) {
      int med = (min + max) >>> 1;
      if (pSeq[med] == pVal) {
        return med;
      }
      if (pSeq[med] < pVal) {
        min = med - 1;
      } else {
        max = med - 1;
      }
    }
    return -1;
  }

  public static int pesquisaTernaria(int[] pSeq, int pInicio, int pFim, int pVal) {
    int min = pInicio;
    int max = pFim;
    int nelem;
    int fpivot;
    int spivot;

    while (min < max) {
      nelem = max - min + 1;
      if (nelem % 3 == 0) {
        fpivot = min + (nelem / 3) - 1;
        spivot = min + (2 * nelem / 3) - 1;
      } else {
        fpivot = min + (nelem / 3);
        spivot = min + (2 * nelem / 3);
      }

      if (pSeq[fpivot] > pVal) {
        max = fpivot - 1;
      } else {
        if (pSeq[spivot] > pVal) {
          min = fpivot;
          max = spivot - 1;
        } else {
          min = spivot;
        }
      }
    }
    if (pSeq[min] == pVal) {
      return min;
    } else {
      return -1;
    }
  }

  public static int interpolacaop(int[] pSeq, int pInicio, int pFim, int pVal) {
    int min = pInicio;
    int max = pFim;
    int med;
    int dif;
    if (pVal < pSeq[min] || pVal > pSeq[max]) {
      return -1;
    }

    while (min <= max) {
      dif = pSeq[max] - pSeq[min];
      if (dif == 0) {
        med = min;
      } else {
        med = min + (pVal - pSeq[min] + (int) (max - min) / dif);
      }
      if (pSeq[med] == pVal) {
        return med;
      }
      if (pSeq[med] > pVal) {
        max = med - 1;
      } else {
        min = med + 1;
      }
    }
    return -1;
  }

  public static int hash(int pVal, int ptabdim) {
    return pVal % ptabdim;
  }

  public static void inserirTabela(int[] pSeq, int pVal) {
    int ph = hash(pVal, pSeq.length);
    if (pSeq[ph] == 0) {
      pSeq[ph] = pVal;
    } else {
      int pos = (ph + 1) % pSeq.length;
      while (pSeq[pos] != 0 && pos != ph) {
        pos = ++pos % pSeq.length;
      }
      if (pos != ph) {
        pSeq[pos] = pVal;
      }
    }
  }

  public static int procuraTabela(int[] pSeq, int pVal) {
    int ph = hash(pVal, pSeq.length);
    if (pSeq[ph] == pVal) {
      return ph;
    } else {
      if (pSeq[ph] == 0) {
        return -1;
      } else {
        int pos = (ph + 1) % pSeq.length;
        while (pSeq[pos] != pVal && pSeq[pos] != 0 && pos != ph) {
          pos = ++pos % pSeq.length;
        }
        if (pSeq[pos] == pVal) {
          return pos;
        } else {
          return -1;
        }
      }
    }
  }

}