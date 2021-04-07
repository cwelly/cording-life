using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class fe_ona : MonoBehaviour {
    public GameObject adb;
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        if (Input.GetKeyDown(KeyCode.E))
            adb.SetActive(false);
	}
}
