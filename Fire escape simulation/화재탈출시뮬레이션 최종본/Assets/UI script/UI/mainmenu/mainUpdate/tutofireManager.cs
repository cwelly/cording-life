using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class tutofireManager : MonoBehaviour {
    [SerializeField] public Image im_nar;
    [SerializeField] public Text imform1;
    [SerializeField] public Text imform2;
    public GameObject fireextin;
    private float time = 10;
    private bool enablestart = false;
    private int fireCount = 3;
    // Use this for initialization
    void Start () {
        imform1.enabled = false;
        imform2.enabled = false;
    }
	
	// Update is called once per frame
	void Update () {
        if (fireCount == 0) {
            enablestart = true;
        }
        if (enablestart)
        {
            time -= Time.deltaTime;
            im_nar.enabled = true;
            if (time >= 5)
            {
                imform1.enabled = true;

            }
            else if (time >= 0)
            {
                imform1.enabled = false;
                imform2.enabled = true;
            }
            else
            {
                imform2.enabled = false;
                im_nar.enabled = false;
                SceneManager.LoadScene("START");
            }
        }
    }

    private void CountDownFire() {
        fireCount--;
    }
}
