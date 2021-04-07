using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;


public class STARTSCRPIT : MonoBehaviour {


    public void startgame()
    {
        Invoke("Startexp", .3f);
    }
    void Startexp()
    {
        Application.LoadLevel("Game");
    }
}
