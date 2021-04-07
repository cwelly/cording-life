using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class tutorialManager : MonoBehaviour {
    public GameObject des1;
    public GameObject des2;
    public GameObject des3;
    public GameObject fireextin;
    public GameObject fireextin_water;
    public GameObject fireextin_bunmal;

    [SerializeField] public Image im_nar;
    [SerializeField] public Image im;
    [SerializeField] public Text imform1;
    [SerializeField] public Text imform2;
    [SerializeField] public Text imform3;
    [SerializeField] public Text imform4;

    private float time = 20;
    private bool enablestart = true;


    void Start () {
        des1.SetActive(false);
        des2.SetActive(false);
        des3.SetActive(false);
        fireextin.SetActive(false);
        fireextin_water.SetActive(false);
        fireextin_bunmal.SetActive(false);
        im_nar.enabled = false;
        im.enabled = false;
        imform1.enabled = false;
        imform2.enabled = false;
        imform3.enabled = false;
        imform4.enabled = false;
    }
	
	// Update is called once per frame
	void Update () {
        if (enablestart)
        {
            im_nar.enabled = true;
            time -= Time.deltaTime;
            if (time >= 15)
            {
                imform1.enabled = true;


            }
            else if (time >= 10)
            {
                imform1.enabled = false;
                imform2.enabled = true;
            }
            else if (time >= 5)
            {
                imform2.enabled = false;
                imform3.enabled = true;
            }
            else if (time >= 0)
            {
                imform3.enabled = false;
                imform4.enabled = true;
            }
            else
            {
                im_nar.enabled = false;
                imform4.enabled = false;
                des1.SetActive(true);
                enablestart = false;
            }
        }
    }
}
