using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Explain : MonoBehaviour {
    
    public void GoExplain() {
        Invoke("Startexp", .3f);
    }
    void Startexp()
    {
        Application.LoadLevel("Explain");
    }
}
