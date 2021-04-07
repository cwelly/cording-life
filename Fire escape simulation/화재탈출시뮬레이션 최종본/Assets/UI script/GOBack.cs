using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;


public class GOBack : MonoBehaviour {

    public void GoBack()
    {
        Invoke("Startexp", .3f);
    }
    void Startexp()
    {
        Application.LoadLevel("START");
    }
}
